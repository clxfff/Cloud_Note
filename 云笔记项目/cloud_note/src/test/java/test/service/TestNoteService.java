package test.service;

import com.lcz.cloud_note.entity.Note;
import com.lcz.cloud_note.service.NoteService;
import com.lcz.cloud_note.util.NoteResult;
import org.junit.Before;
import org.junit.Test;
import test.TestBase;

import java.util.List;
import java.util.Map;

public class TestNoteService  extends TestBase{
	private NoteService noteService;
	@Before
	public void init() {
		noteService = super.getContext().getBean("noteService",NoteService.class);
	}
	@Test
	public void testNoteService() {
		NoteResult<List<Map>> result = noteService.loadBookNotes("20b4cbec-bd55-4c21-9c41-3a11ada2b803");
		System.out.println(result.getStatus());
		System.out.println(result.getMsg());
	}
	@Test
	public void testShow() {
		NoteResult<Note> result = noteService.loadNote("003ec2a1-f975-4322-8e4d-dfd206d6ac0c");
		System.out.println(result.getStatus());
		System.out.println(result.getMsg());
		System.out.println(result.getData());
	}

}
