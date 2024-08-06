package controller;

import entity.RatingsEntity;
import model.IModel.IRatingsModel;
import model.Impl.RatingsModelImpl;

public class RatingsController {
    IRatingsModel controller = new RatingsModelImpl();

    public RatingsEntity RatingCreate(RatingsEntity response){
        return this.controller.create(response);
    }

    public RatingsEntity ratingUpdate(RatingsEntity response){
        return this.controller.update(response);
    }
}
