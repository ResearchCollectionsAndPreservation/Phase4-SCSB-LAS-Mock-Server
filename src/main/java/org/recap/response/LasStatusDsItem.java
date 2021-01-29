package org.recap.response;

import java.util.List;

import lombok.Data;

@Data
public class LasStatusDsItem {
    private List<LasStatusTtItem> ttitem;
}
