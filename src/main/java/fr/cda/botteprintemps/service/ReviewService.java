package fr.cda.botteprintemps.service;

import fr.cda.botteprintemps.dto.ReviewDTO;
import fr.cda.botteprintemps.entity.Review;
import fr.cda.botteprintemps.repository.ReviewRepository;
import fr.cda.botteprintemps.service.LodgingService;
import fr.cda.botteprintemps.service.UserService;
import fr.cda.botteprintemps.service.interfaces.ServiceListInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService implements
        ServiceListInterface<Review, Long, ReviewDTO, ReviewDTO> {

    private ReviewRepository reviewRepository;

    private UserService userService;

    private LodgingService lodgingService;

    @Override
    public Review create(ReviewDTO o) {
        return reviewRepository.saveAndFlush(getObjectFromDTO(new Review(), o));
    }

    @Override
    public Review update(ReviewDTO o, Long id) {
        Review review = getObjectFromDTO(findOneById(id), o);
        reviewRepository.flush();
        return review;
    }

    @Override
    public void delete(Review o) {
        reviewRepository.delete(o);
    }

    @Override
    public Review findOneById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<?> list() {
        return reviewRepository.findAll();
    }

    private Review getObjectFromDTO(Review review, ReviewDTO dto) {
        review.setContent(dto.getContent());
        review.setRating(dto.getRating());
        review.setUser(userService.findOneById(dto.getUserId()));
        review.setLodging(lodgingService.findOneById(dto.getLodgingId()));
        return review;
    }
}
