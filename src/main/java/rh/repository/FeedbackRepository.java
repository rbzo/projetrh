package rh.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rh.entities.Feedback;
import rh.entities.FeedbackThemes;
import rh.entities.Theme;
import rh.security.Role;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
	@Query("select f from Feedback f where f.collaborateur.id=:x")
	public List<Feedback> findFeedbacksByCollaborateur(@Param("x") Long idCollaborateur);
	
	//liste des themes d'un feedback identifie par son id
	
	@Query("select ft.theme from FeedbackThemes ft where ft.feedback.id=:x")
	Set<Theme> getThemes(@Param("x") long idFeedback);
	
	@Query("select ft from FeedbackThemes ft where ft.feedback.id=:x")
	public Page<FeedbackThemes> getThemesV2(@Param("x") long id, Pageable p);
	
	//liste de feedbacktheme par identifiant de feedback
	@Query("select ft from FeedbackThemes ft where ft.feedback.id=:x")
	public Set<FeedbackThemes> findByFeedback(@Param("x") Long idFeedBack);
	
	//feedbacktheme precis en fontion du feedback et du theme relatif
	//liste de feedbacktheme par identifiant de feedback
		@Query("select ft from FeedbackThemes ft where ft.feedback.id=:x and ft.theme.id=:y")
		public FeedbackThemes findByFeedback(@Param("x") Long idFeedBack, @Param("y") Long idTheme);
	


}
