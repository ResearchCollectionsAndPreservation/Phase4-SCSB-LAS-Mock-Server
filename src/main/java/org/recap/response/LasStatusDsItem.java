package org.recap.response;

import lombok.Data;

import java.util.List;

@Data
public class LasStatusDsItem {
    private List<LasStatusTtItem> ttitem;
}
