package com.msj_02_smis_dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IStudentHandler<T> {
 T handle(ResultSet rs) throws SQLException;
}
