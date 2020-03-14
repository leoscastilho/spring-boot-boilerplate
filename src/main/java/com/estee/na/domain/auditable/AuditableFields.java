package com.estee.na.domain.auditable;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

public class AuditableFields {

    @PreUpdate
    public void updateAuditableFields(final Auditable obj) {
        String user = "USER";

        obj.setUpdateDt(new Date());
        obj.setUpdateUser(user);
    }

    // TIP: if the createDt and createUser of an obj are null, check where the object is being updated.
    // It can be the an obj not coming from the db being updated. All obj that are updated MUST come from the db.
    @PrePersist
    public void createAuditableFields(final Auditable obj) {
        String user = "USER";

        Date now = new Date();
        obj.setCreateDt(now);
        obj.setUpdateDt(now);

        obj.setCreateUser(user);
        obj.setUpdateUser(user);
    }
}
