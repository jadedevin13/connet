package org.connet.dto.network;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PublishIpRequest {

    private List<PublicIpDetailRequest> publicIpAddress;
}
