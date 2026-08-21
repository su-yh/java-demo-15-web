package com.eb.business.dto;

import com.eb.constant.enums.BaseEnum;
import lombok.Getter;

/**
 * @author suyh
 * @since 2026-08-21
 */
@Getter
public enum PesSectorEnums implements BaseEnum {
    DESIGN(SectorCodes.DESIGN_CODE, "Design"),
    EQUIPMENT(SectorCodes.EQUIPMENT_CODE, "Equipment"),
    CONSTRUCTION(SectorCodes.CONSTRUCTION_CODE, "Construction"),
    COMMISSIONING(SectorCodes.COMMISSIONING_CODE, "Commissioning"),
    MANAGE(SectorCodes.MANAGE_CODE, "Manage"),
    ;


    private final String code;
    private final String desc;

    PesSectorEnums(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
