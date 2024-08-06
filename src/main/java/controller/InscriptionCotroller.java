package controller;

import entity.InscriptionEntity;
import model.IModel.IInscriptionModel;
import model.Impl.InscriptionModelImpl;

public class InscriptionCotroller {
    IInscriptionModel controller = new InscriptionModelImpl();

    public InscriptionEntity InscriptionCreate(InscriptionEntity response){
        return this.controller.create(response);
    }

    public void InscriptionDelete(InscriptionEntity response){
        this.controller.delete(response);
    }

    public InscriptionEntity InscriptionRead (InscriptionEntity response){
        return this.controller.read(response);
    }
}
