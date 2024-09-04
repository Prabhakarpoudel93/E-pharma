package com.eq.epharma.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eq.epharma.dto.MedicinesDto;
import com.eq.epharma.dto.MessageDto;
import com.eq.epharma.repo.MedicinesRepo;

@Service
public class MedicinesServiceImpl implements MedicinesService {

    @Autowired
    MedicinesRepo mr;

    @Override
    public MessageDto addMedicines(MedicinesDto medicinesDto) {
        medicinesDto.setmedicineId(mr.getMaxMedicineId() + 1);

        int result = 0;

        Optional<MedicinesDto> existingMedicine = mr.getByMedicineName(medicinesDto.getmedicineName());
        MessageDto md = new MessageDto("Failed", false);
        System.out.println(
                "Medicine Name is : " + medicinesDto.getmedicineName() + "And existing Medicine : " + existingMedicine);
        if (existingMedicine.isEmpty()) {
            result = mr.addMedicines(medicinesDto);
        } else {
            md.setMessage("Medicine Already Exists");
            md.setStatus(false);
        }

        if (result > 0) {
            md.setMessage("Medicine Added Successfully");
            md.setStatus(true);
        }
        return md;
    }

    @Override
    public Optional<List<MedicinesDto>> getAllMedicines() {
        return mr.getAllMedicines();
    }

    @Override
    public MedicinesDto findByMedicineId(int id) {
        return mr.findByMedicineId(id);
    }

    @Override
    public MessageDto updateMedicine(MedicinesDto medicinesDtoUpdate) {
        int flag = 0;
        MessageDto md = new MessageDto("failed", false);
        flag = mr.updateMedicine(medicinesDtoUpdate);
        if (flag > 0) {
            md.setMessage("Medicine Updated Successfully");
            md.setStatus(true);
        }
        return md;
    }

}
