package cad.osb.iaspr_1.dto;

import cad.osb.iaspr_1.domain.Answer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnswerDTO {
    List<Answer> answers;
}
