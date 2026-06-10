# k6 Result - 02-mixed-shop-traffic

## Summary

| Metric | Value |
| --- | ---: |
| http_reqs | 2118 |
| iterations | 2118 |
| checks success rate | 99.92% |
| http_req_failed | 0.14% |
| data_received bytes | 955763 |
| data_sent bytes | 219415 |

## Duration Metrics

| Metric | avg(ms) | min(ms) | med(ms) | p90(ms) | p95(ms) | p99(ms) | max(ms) |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| http_req_duration | 114.70 | 0.59 | 4.76 | 517.96 | 522.17 | 530.59 | 1083.80 |
| http_req_waiting | 114.26 | 0.50 | 4.42 | 517.31 | 521.66 | 530.20 | 1071.62 |
| http_req_blocked | 0.03 | 0 | 0 | 0 | 0 | 0.99 | 11.31 |
| http_req_connecting | 0.02 | 0 | 0 | 0 | 0 | 0.93 | 1.21 |

## Metric Meaning

| Value | Meaning |
| --- | --- |
| avg | 전체 요청 시간의 산술 평균입니다. outlier의 영향을 받을 수 있습니다. |
| min | 가장 빠른 요청 시간입니다. 정상 동작의 하한선을 볼 때 사용합니다. |
| med | 중앙값입니다. 요청의 절반은 이 값보다 빠르고 절반은 느립니다. |
| p90 | 90% 요청이 이 값 이하로 완료됩니다. |
| p95 | 95% 요청이 이 값 이하로 완료됩니다. 수업의 주요 합격 기준입니다. |
| p99 | 99% 요청이 이 값 이하로 완료됩니다. tail latency 관찰에 사용합니다. |
| max | 가장 느린 요청 시간입니다. 단일 outlier 여부를 확인할 때 사용합니다. |

## Thresholds

| Threshold | Result |
| --- | --- |
| popular: status is 200 | 1669 pass / 0 fail |
| popular: response is array | 1669 pass / 0 fail |
| order: status is 201 or business failure 400 | 446 pass / 3 fail |

## How To Compare

| Compare Point | What To Look For |
| --- | --- |
| p95 | 사용자 대부분이 체감하는 지연 시간 악화 여부 |
| http_req_failed | 4xx/5xx 또는 check 실패 증가 여부 |
| http_req_waiting | 서버 처리나 DB 처리 지연 가능성 |
| Prometheus | 서버 내부 HTTP/custom metric 추세 |
| Loki | 느린 요청의 traceId와 event 로그 |

