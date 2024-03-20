package com.example.personal.Dto.Information;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QInformationEntity is a Querydsl query type for InformationEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QInformationEntity extends EntityPathBase<InformationEntity> {

    private static final long serialVersionUID = 1935556641L;

    public static final QInformationEntity informationEntity = new QInformationEntity("informationEntity");

    public final StringPath id = createString("id");

    public final SimplePath<com.example.personal.Dto.MemberDto> memberDto = createSimple("memberDto", com.example.personal.Dto.MemberDto.class);

    public final StringPath use_yn = createString("use_yn");

    public QInformationEntity(String variable) {
        super(InformationEntity.class, forVariable(variable));
    }

    public QInformationEntity(Path<? extends InformationEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QInformationEntity(PathMetadata metadata) {
        super(InformationEntity.class, metadata);
    }

}

