package com.grad.onlinecatalog.service;

import com.grad.onlinecatalog.model.SchoolUnit;
import com.grad.onlinecatalog.repository.SchoolUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ISchoolUnitService")
public class SchoolUnitService {

        @Autowired
        private SchoolUnitRepository schoolUnitRepository;


        public List<SchoolUnit> findAll() {
            return schoolUnitRepository.findAll();
        }

        public void save(SchoolUnit schoolUnit) {
            schoolUnitRepository.save(schoolUnit);
        }

        public String findSchoolsByUnit(Integer id) {
            //TODO: try catch / check if present
            return schoolUnitRepository.findById(id).get().getUnitName();
        }

        public SchoolUnit findById(Integer id) {
            Optional<SchoolUnit> schoolUnit = schoolUnitRepository.findById(id);
            if (schoolUnit.isPresent()) {
                return schoolUnit.get();
            }
            return null;
        }

        public void deleteById(Integer id) {
            schoolUnitRepository.deleteById(id);
        }

    }

