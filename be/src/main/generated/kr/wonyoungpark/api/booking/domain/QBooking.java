package kr.wonyoungpark.api.booking.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBooking is a Querydsl query type for Booking
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBooking extends EntityPathBase<Booking> {

    private static final long serialVersionUID = -1621768941L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBooking booking = new QBooking("booking");

    public final StringPath bookDate = createString("bookDate");

    public final StringPath bookEmail = createString("bookEmail");

    public final StringPath bookName = createString("bookName");

    public final NumberPath<Long> bookNum = createNumber("bookNum", Long.class);

    public final StringPath bookPnumber = createString("bookPnumber");

    public final kr.wonyoungpark.api.exhbn.domain.QExhbn exhbn;

    public final StringPath totalPrice = createString("totalPrice");

    public final kr.wonyoungpark.api.user.domain.QUserVo user;

    public QBooking(String variable) {
        this(Booking.class, forVariable(variable), INITS);
    }

    public QBooking(Path<? extends Booking> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBooking(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBooking(PathMetadata metadata, PathInits inits) {
        this(Booking.class, metadata, inits);
    }

    public QBooking(Class<? extends Booking> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.exhbn = inits.isInitialized("exhbn") ? new kr.wonyoungpark.api.exhbn.domain.QExhbn(forProperty("exhbn"), inits.get("exhbn")) : null;
        this.user = inits.isInitialized("user") ? new kr.wonyoungpark.api.user.domain.QUserVo(forProperty("user")) : null;
    }

}

