package org.connet.dto.network;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PublicIpDetailRequest {
    private String ipAddress;
    private String provider;
}
