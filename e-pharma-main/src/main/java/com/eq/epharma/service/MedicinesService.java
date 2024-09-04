package com.eq.epharma.service;

import java.util.List;
import java.util.Optional;

import com.eq.epharma.dto.MedicinesDto;
import com.eq.epharma.dto.MessageDto;

public interface MedicinesService {

    public MessageDto addMedicines(MedicinesDto medicinesDto);

    public Optional<List<MedicinesDto>> getAllMedicines();

    public MedicinesDto findByMedicineId(int id);

    public MessageDto updateMedicine(MedicinesDto medicinesDtoUpdate);

}
