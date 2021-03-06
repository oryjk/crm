package com.contact.typeHandler;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by sarahzhou on 5/15/16.
 */
public class AddressHandler extends BaseTypeHandler {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String linkMans = rs.getString(columnName);
        List<Map<String, Object>> linkManList = (List<Map<String, Object>>) JSON.parse(linkMans);
        if (CollectionUtils.isEmpty(linkManList)) {
            return null;
        }
        Map<String, Object> firstContact = getFirstContact(linkManList);
        return buildAddress(firstContact);
    }

    @Override
    public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String linkMans = rs.getString(columnIndex);
        List<Map<String, Object>> linkManList = (List<Map<String, Object>>) JSON.parse(linkMans);
        if (CollectionUtils.isEmpty(linkManList)) {
            return null;
        }
        Map<String, Object> firstContact = getFirstContact(linkManList);
        return buildAddress(firstContact);
    }

    @Override
    public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }

    private Map<String, Object> getFirstContact(List<Map<String, Object>> linkManList) {
        Map<String, Object> firstContact = null;
        for (Map<String, Object> contact : linkManList) {
            if (Integer.parseInt(contact.get("linkFirst").toString()) == 1) {
                firstContact = contact;
                break;
            }
        }
        if (firstContact == null) {
            firstContact = linkManList.get(0);
        }
        return firstContact;
    }

    private String buildAddress(Map<String, Object> link) {
        StringBuilder sb = new StringBuilder();
        Object province = link.get("province");
        if (province != null) {
            sb.append(province.toString());
        }
        Object city = link.get("city");
        if (city != null) {
            sb.append("," + city.toString());
        }
        Object county = link.get("county");
        if (county != null) {
            sb.append("," + county.toString());
        }
        Object address = link.get("address");
        if (address != null) {
            sb.append("," + address.toString());
        }
        return sb.toString();
    }
}
