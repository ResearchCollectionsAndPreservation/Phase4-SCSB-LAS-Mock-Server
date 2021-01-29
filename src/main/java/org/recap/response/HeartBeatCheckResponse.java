package org.recap.response;

import lombok.Data;

@Data
public class HeartBeatCheckResponse {
    private boolean success;
    private String screenMessage;
}
