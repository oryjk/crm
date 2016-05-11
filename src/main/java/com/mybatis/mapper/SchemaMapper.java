package com.mybatis.mapper;

import org.springframework.stereotype.Repository;

/**
 * Created by carlwang on 5/11/16.
 */
@Repository
public interface SchemaMapper extends SqlMapper {
    void createSchema(String schemaName, String charset, String collate);

    int select();
}
