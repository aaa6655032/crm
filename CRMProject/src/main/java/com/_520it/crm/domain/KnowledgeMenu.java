package com._520it.crm.domain;

import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
@Alias("KnowledgeMenu")
public class KnowledgeMenu {
    private Long id;
    private String text;
    private Boolean state;
    private Boolean checked;
    private String attributes;
    private List<KnowledgeMenu> children;

}