package com.eq.epharma.repo;

import java.util.List;
import java.util.Optional;

import com.eq.epharma.dto.MedicinesDto;

public interface MedicinesRepo {
    public int addMedicines(MedicinesDto medicines);

    public int getMaxMedicineId();

    public Optional<MedicinesDto> getByMedicineName(String m);

    public Optional<List<MedicinesDto>> getAllMedicines();

    public MedicinesDto findByMedicineId(int id);

    public int updateMedicine(MedicinesDto medicinesDtoUpdate);

}