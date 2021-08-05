package org.recap.request;

import lombok.Data;

import java.util.List;

@Data
public class RetrieveItemEDDRequest {
    private List<TtitemEDDResponse> ttitem;
}
