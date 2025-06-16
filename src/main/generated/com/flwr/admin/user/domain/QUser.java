package com.flwr.admin.user.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -580608655L;

    public static final QUser user = new QUser("user");

    public final BooleanPath acceptTerms = createBoolean("acceptTerms");

    public final StringPath address1 = createString("address1");

    public final StringPath address2 = createString("address2");

    public final DatePath<java.time.LocalDate> birthday = createDate("birthday", java.time.LocalDate.class);

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final StringPath email = createString("email");

    public final StringPath firstName = createString("firstName");

    public final StringPath firstNameKana = createString("firstNameKana");

    public final EnumPath<User.Gender> gender = createEnum("gender", User.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lastName = createString("lastName");

    public final StringPath lastNameKana = createString("lastNameKana");

    public final StringPath password = createString("password");

    public final StringPath phone = createString("phone");

    public final StringPath postalCode = createString("postalCode");

    public final StringPath prefecture = createString("prefecture");

    public final EnumPath<User.UserRole> role = createEnum("role", User.UserRole.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

