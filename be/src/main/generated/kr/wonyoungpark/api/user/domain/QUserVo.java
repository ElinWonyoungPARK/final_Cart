package kr.wonyoungpark.api.user.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserVo is a Querydsl query type for UserVo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserVo extends EntityPathBase<UserVo> {

    private static final long serialVersionUID = -2086059814L;

    public static final QUserVo userVo = new QUserVo("userVo");

    public final StringPath admin = createString("admin");

    public final ListPath<kr.wonyoungpark.api.analysis.domain.Analysis, kr.wonyoungpark.api.analysis.domain.QAnalysis> analyses = this.<kr.wonyoungpark.api.analysis.domain.Analysis, kr.wonyoungpark.api.analysis.domain.QAnalysis>createList("analyses", kr.wonyoungpark.api.analysis.domain.Analysis.class, kr.wonyoungpark.api.analysis.domain.QAnalysis.class, PathInits.DIRECT2);

    public final StringPath birthday = createString("birthday");

    public final ListPath<kr.wonyoungpark.api.booking.domain.Booking, kr.wonyoungpark.api.booking.domain.QBooking> bookings = this.<kr.wonyoungpark.api.booking.domain.Booking, kr.wonyoungpark.api.booking.domain.QBooking>createList("bookings", kr.wonyoungpark.api.booking.domain.Booking.class, kr.wonyoungpark.api.booking.domain.QBooking.class, PathInits.DIRECT2);

    public final StringPath email = createString("email");

    public final StringPath gender = createString("gender");

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final StringPath preferGenre = createString("preferGenre");

    public final ListPath<kr.wonyoungpark.api.review.domain.Review, kr.wonyoungpark.api.review.domain.QReview> reviews = this.<kr.wonyoungpark.api.review.domain.Review, kr.wonyoungpark.api.review.domain.QReview>createList("reviews", kr.wonyoungpark.api.review.domain.Review.class, kr.wonyoungpark.api.review.domain.QReview.class, PathInits.DIRECT2);

    public final ListPath<Role, EnumPath<Role>> roles = this.<Role, EnumPath<Role>>createList("roles", Role.class, EnumPath.class, PathInits.DIRECT2);

    public final StringPath username = createString("username");

    public final NumberPath<Long> userNum = createNumber("userNum", Long.class);

    public QUserVo(String variable) {
        super(UserVo.class, forVariable(variable));
    }

    public QUserVo(Path<? extends UserVo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserVo(PathMetadata metadata) {
        super(UserVo.class, metadata);
    }

}

