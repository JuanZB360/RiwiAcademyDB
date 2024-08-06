package model.IModel;

import entity.RatingsEntity;
import persistence.CRUD.Create;
import persistence.CRUD.Update;

public interface IRatingsModel extends  Create<RatingsEntity>,
                                        Update<RatingsEntity> {}
