package com.eb.business.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import org.springframework.lang.NonNull;

/**
 * json 的抽象类或者接口类的序列化与反序列化
 *
 * @author suyh
 * @since 2026-08-21
 */
// visible = true，则属性sector 有值，非null。但是json 序列化时会有两个相同的 sector 属性的情况。
// visible = false，则属性sector 的值总是null。但是json 序列化时会有sector 的值。
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "sector", visible = false)
@JsonSubTypes({
        // name 需要对应 枚举json 序列化的值
        @JsonSubTypes.Type(value = PesSectorDesign.class, name = SectorCodes.DESIGN_CODE),
        @JsonSubTypes.Type(value = PesSectorEquipment.class, name = SectorCodes.EQUIPMENT_CODE),
        @JsonSubTypes.Type(value = PesSectorConstruction.class, name = SectorCodes.CONSTRUCTION_CODE),
        @JsonSubTypes.Type(value = PesSectorCommissioning.class, name = SectorCodes.COMMISSIONING_CODE),
        @JsonSubTypes.Type(value = PesSectorManage.class, name = SectorCodes.MANAGE_CODE),
})
@Data
public abstract class AbstractPesSector {
    /**
     * 获取所属板块
     * @return 枚举板块
     */
    // @ApiModelProperty("所属板块")
    @NonNull
    public abstract PesSectorEnums getSector();
}
