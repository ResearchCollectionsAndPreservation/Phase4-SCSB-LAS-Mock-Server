package org.recap.request;

import lombok.Data;

import java.util.List;

@Data
public class RetrieveItemRequest {
    private List<TtitemRequest> ttitem;
}
