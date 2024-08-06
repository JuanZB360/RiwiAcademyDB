package model.IModel;

import entity.InscriptionEntity;
import persistence.CRUD.Create;
import persistence.CRUD.Delete;
import persistence.CRUD.Read;

public interface IInscriptionModel extends      Create<InscriptionEntity>,
                                                Read<InscriptionEntity>,
                                                Delete<InscriptionEntity>{}
