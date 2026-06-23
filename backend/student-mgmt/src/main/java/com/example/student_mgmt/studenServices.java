package com.example.student_mgmt;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class studenServices {
	private studentRepository studentRepository;
	public studenServices(studentRepository studentRepository) {
		this.studentRepository=studentRepository;
	}
	@Transactional
	public void save(student student) {
		studentRepository.save(student);
	}
	public Optional<student> find(int id) {
		return studentRepository.findById(id);
	}
	public List<student> findAll(){
		return studentRepository.findAll();
	}
	@Transactional
	public void delete(int id) {
		studentRepository.deleteById(id);
	}
	@Transactional
	public void update(int id ,student s) {
		student student=studentRepository.findById(id).orElse(null);
		if(student !=null) {
			student.setBranch(s.getBranch());
			student.setName(s.getName());
			student.setCgpa(s.getCgpa());
			studentRepository.save(student);
		}
	}
}
