package org.recap.request;

import lombok.Data;

import java.util.List;

@Data
public class LasStatusCheckRequest {
    private List<LasStatus> lasStatus;
}
