package org.example.Services;

import org.example.Entity.Patient;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PatientService {
    void addPatient(Patient patient) throws SQLException;
    void deletePatient(int id) throws SQLException;
    boolean checkPatientLogin(String patientId, String password) throws SQLException;
    Patient getPatientById(int id) throws SQLException;
    Patient getPatientByName(String name) throws SQLException;
    void updatePatient(Patient patient) throws SQLException;
    ArrayList<Patient> getAllPatients() throws SQLException;
    void updatePassword(int id, String password) throws SQLException;
}
