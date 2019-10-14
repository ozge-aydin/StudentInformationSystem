package com.spring.jsf.sis.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.jsf.sis.model.Student;
import com.spring.jsf.sis.model.StudentFile;
import com.spring.jsf.sis.service.StudentFileService;
import com.spring.jsf.sis.service.StudentService;

//@Getter
//@Setter
//@ManagedBean
@ViewScoped
@Controller
@SessionScoped
public class StudentFileController implements Serializable {

	private static final long serialVersionUID = 1L;

//	@ManagedProperty("#{studentFileService}")
	@Autowired
	private StudentFileService studentFileService;
	
	@Autowired
	private StudentService studentService;
	
	private List<Student> students;
	
	private List<StudentFile> studentFiles;
	
	private StudentFile studentFile = new StudentFile();
	
	private UploadedFile file;
	
	private StreamedContent file2;
	    
    private int studentId;
    
	
	public void loadStudentFiles() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("pageId");

		if (id != null) {
			studentId = Integer.parseInt(id);

			if (studentId == 0) {
				studentFiles = studentFileService.findAll();
			} else {
				studentFiles = studentFileService.findByStudentId(studentId);
			}
		} else {
			if (studentId == 0) {
				studentFiles = studentFileService.findAll();
			} else {
				studentFiles = studentFileService.findByStudentId(studentId);
			}
		}
		students = studentService.findAll();
	}
	
	public String onload() { 
		loadStudentFiles();
	    return "studentFile?faces-redirect=true";
	}
	
	public void save() {
		
		if(file !=null)
			System.out.println("Uploaded File Name Is :: "+file.getFileName()+" :: Uploaded File Size :: "+file.getSize());
			else
				System.out.println("--------------- file null ---------");
		
		try {
			
			InputStream input= file.getInputstream();

			ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] buffer = new byte[(int)file.getSize()];
			
			for (int length = 0; (length = input.read(buffer))>0;) {
				output.write(buffer,0,length);
			}
			studentFile.setFile(output.toByteArray());
			studentFile.setFileName(file.getFileName());
			studentFile.setFileType(file.getContentType());

			studentFileService.save(studentFile);
			studentFile = new StudentFile();
			
			loadStudentFiles();
			
			FacesContext.getCurrentInstance().addMessage
				(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Belge kaydetme iþlemi gerçekleþtirilmiþtir!", null));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Belge kaydetme iþlemi yapýlamadý!", null));
		}
		
	}
	
	public void remove(StudentFile studentFile) {
		studentFileService.remove(studentFile);
		loadStudentFiles();
		FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Belge kaydý silinmiþtir!", null));
	}
	
	public void clear() {
		studentFile = new StudentFile();
		this.studentFile.setStudentId(studentId);
	}
	
	public StreamedContent dowload(int studentFileId) throws FileNotFoundException { 
		
		StudentFile  sFile = new StudentFile();
		sFile= studentFileService.findStudentFile(studentFileId);
		byte[] fileByte = sFile.getFile();
		InputStream stream = new ByteArrayInputStream(fileByte);

		System.out.println(stream.getClass().getCanonicalName());
		System.out.println(stream.getClass().getTypeParameters());
		
		return new DefaultStreamedContent(stream, sFile.getFileType(), sFile.getFileName());
		
}
	
	public List<StudentFile> getStudentFiles() {
		return studentFiles;
	}

	public void setStudentFiles(List<StudentFile> studentFiles) {
		this.studentFiles = studentFiles;
	}
	
	public StudentFile getStudentFile() {
		return studentFile;
	}

	public void setStudentFile(StudentFile studentFile) {
		this.studentFile = studentFile;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public StreamedContent getFile2() {
		return file2;
	}

	public void setFile2(StreamedContent file2) {
		this.file2 = file2;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
}
