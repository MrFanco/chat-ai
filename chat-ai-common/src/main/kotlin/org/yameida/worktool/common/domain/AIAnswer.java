package org.yameida.worktool.common.domain;

import lombok.Data;

import java.util.List;

/**
 * ai
 */
@Data
public class AIAnswer {

    private String id;

    private String object;

    private int created;

    private String model;

    private List<Choices> choices;

}
