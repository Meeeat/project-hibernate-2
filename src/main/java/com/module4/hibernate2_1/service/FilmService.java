package com.module4.hibernate2_1.service;

import com.module4.hibernate2_1.config.HibernateSessionFactory;
import com.module4.hibernate2_1.dao.*;
import com.module4.hibernate2_1.entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class FilmService {

    private final FilmDAO filmDAO = DAOFactory.getFilmDAO();
    private final LanguageDAO languageDAO = DAOFactory.getLanguageDAO();
    private final ActorDAO actorDAO = DAOFactory.getActorDAO();
    private final CategoryDAO categoryDAO = DAOFactory.getCategoryDAO();
    private final InventoryDAO inventoryDAO = DAOFactory.getInventoryDAO();
    private final StoreDAO storeDAO = DAOFactory.getStoreDAO();

    public void addNewFilm(
            String title,
            String description,
            int releaseYear,
            byte languageId,
            Set<Short> actorIds,
            Set<Byte> categoryIds,
            byte rentalDuration,
            BigDecimal rentalRate,
            short length,
            BigDecimal replacementCost,
            Rating rating,
            Set<SpecialFeature> specialFeatures,
            byte storeId
    ) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Language language = languageDAO.findById(languageId);
            if (language == null) {
                throw new RuntimeException("Language not found with ID: " + languageId);
            }

            Set<Actor> actors = new HashSet<>();
            for (Short actorId : actorIds) {
                Actor actor = actorDAO.findById(actorId);
                if (actor == null) {
                    throw new RuntimeException("Actor not found with ID: " + actorId);
                }
                actors.add(actor);
            }

            Set<Category> categories = new HashSet<>();
            for (Byte categoryId : categoryIds) {
                Category category = categoryDAO.findById(categoryId);
                if (category == null) {
                    throw new RuntimeException("Category not found with ID: " + categoryId);
                }
                categories.add(category);
            }

            Store store = storeDAO.findById(storeId);
            if (store == null) {
                throw new RuntimeException("Store not found with ID: " + storeId);
            }

            Film film = new Film();
            film.setTitle(title);
            film.setDescription(description);
            film.setReleaseYear(releaseYear);
            film.setLanguage(language);
            film.setActors(actors);
            film.setCategories(categories);
            film.setRentalDuration(rentalDuration);
            film.setRentalRate(rentalRate);
            film.setLength(length);
            film.setReplacementCost(replacementCost);
            film.setRating(rating);
            film.setFeatures(specialFeatures);
            filmDAO.save(film);

            Inventory inventory = new Inventory();
            inventory.setFilm(film);
            inventory.setStore(store);
            inventoryDAO.save(inventory);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to add new film", e);
        } finally {
            session.close();
        }
    }
}