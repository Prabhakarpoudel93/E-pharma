package com.eq.epharma.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.eq.epharma.dto.MedicinesDto;

@Repository
public class MedicinesRepoImpl implements MedicinesRepo {
    private final JdbcTemplate jt;

    public MedicinesRepoImpl(JdbcTemplate jt) {
        this.jt = jt;
    }

    @Override
    public int addMedicines(MedicinesDto medicines) {
        int flag = 0;
        String sql = "insert into medicines (medicineId,medicineName, medicineDescription) values (?,?,?)";
        try {
            flag = this.jt.update(sql, medicines.getmedicineId(), medicines.getmedicineName(),
                    medicines.getmedicineDescription());

        } catch (Exception e) {
            flag = 0;

        }

        return flag;
    }

    @Override
    public int getMaxMedicineId() {
        int maxMedicineId = 0;
        String sql = "select max(medicineId) from medicines";
        try {
            maxMedicineId = this.jt.queryForObject(sql, Integer.class);
        } catch (Exception e) {

        }
        return maxMedicineId;
    }

    @Override
    public Optional<MedicinesDto> getByMedicineName(String m) {
        String sql = "SELECT * FROM Medicines where medicineName=?";
        try {

            return Optional.ofNullable(this.jt.queryForObject(sql,
                    BeanPropertyRowMapper.newInstance(MedicinesDto.class), new Object[] { m }));

        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<MedicinesDto>> getAllMedicines() {
        String sql = "SELECT * FROM Medicines";
        try {

            return Optional.ofNullable(this.jt.query(sql, BeanPropertyRowMapper.newInstance(MedicinesDto.class)));

        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public MedicinesDto findByMedicineId(int id) {
        String sql = "SELECT * FROM medicines where medicineId=?";

        try {
            return this.jt.queryForObject(sql, BeanPropertyRowMapper.newInstance(MedicinesDto.class), id);
        } catch (Exception e) {
            return new MedicinesDto();
        }
    }

    @Override
    public int updateMedicine(MedicinesDto medicinesDtoUpdate) {
        int flag = 0;
        String sql = "UPDATE medicines SET medicineName=?,medicineDescription=? WHERE medicineId=?";
        try {
            flag = this.jt.update(sql, medicinesDtoUpdate.getmedicineName(),
                    medicinesDtoUpdate.getmedicineDescription(), medicinesDtoUpdate.getmedicineId());
        } catch (Exception e) {
            flag = 0;
        }
        return flag;
    }

}
