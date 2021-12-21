package com.company.model;

import lombok.*;

@Generated
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Solution {
    private int problemId;
    private int cost;

    public Solution(int cost) {
        this.cost = cost;
    }
}
