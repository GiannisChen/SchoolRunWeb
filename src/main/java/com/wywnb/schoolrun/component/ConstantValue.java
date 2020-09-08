package com.wywnb.schoolrun.component;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:properties/constant-set.properties")
@Data
public class ConstantValue {
    @Value("${tencent.key}")
    private String tMapKey;
}
