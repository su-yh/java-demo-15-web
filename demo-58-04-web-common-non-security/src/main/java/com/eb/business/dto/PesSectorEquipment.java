package com.eb.business.dto;

import org.springframework.lang.NonNull;

/**
 * @author suyh
 * @since 2026-08-21
 */
public class PesSectorEquipment extends AbstractPesSector {
    @NonNull
    @Override
    public PesSectorEnums getSector() {
        return PesSectorEnums.EQUIPMENT;
    }
}
