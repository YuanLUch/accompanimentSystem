package org.example.Services;

import org.example.Dao.PatientDao;
import org.example.Entity.Patient;

import java.sql.SQLException;
import java.util.ArrayList;

public class PatientServiceImpl implements PatientService {
    PatientDao patientDao = new PatientDao();

    public PatientServiceImpl() throws Exception {
    }

    @Override
    public void addPatient(Patient patient) throws SQLException {
        patientDao.addPatient(patient);
    }

    @Override
    public void deletePatient(int id) throws SQLException {
        patientDao.deletePatient(id);
    }

    @Override
    public boolean checkPatientLogin(String name, String password) throws SQLException {
        Patient patient = patientDao.getPatientByName(name);
        if (patient != null) {
            return patient.getPatientPassword().equals(password);
        }
        return false;
    }

    @Override
    public Patient getPatientById(int id) throws SQLException {
        return patientDao.getPatientById(id);
    }

    @Override
    public Patient getPatientByName(String name) throws SQLException {
        return patientDao.getPatientByName(name);
    }

    @Override
    public void updatePatient(Patient patient) throws SQLException {
        patientDao.updatePatient(patient);
    }

    @Override
    public ArrayList<Patient> getAllPatients() throws SQLException {
        return patientDao.getAllPatient();
    }

    @Override
    public void updatePassword(int id, String password) throws SQLException {
        patientDao.updatePassword(id, password);
    }
}
