package pl.bykowski.springbootsoapexample;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pl.bykowski.springbootsoapexample.student.GetResponse;
import pl.bykowski.springbootsoapexample.student.GetStudent;
import pl.bykowski.springbootsoapexample.student.Student;

@Endpoint
public class StudentEndpoint {

    private StudentServis studentServis;

    public StudentEndpoint(StudentServis studentServis) {
        this.studentServis = studentServis;
    }

    @PayloadRoot(namespace = "http://bykowski.pl/soup-example", localPart = "getStudent")
    @ResponsePayload
    public GetResponse getStudentById(@RequestPayload GetStudent getStudent) {
        Student studentsById = studentServis.getStudentsById(getStudent.getId());;
        GetResponse getResponse = new GetResponse();
        getResponse.setStudent(studentsById);
        return getResponse;
    }
}
