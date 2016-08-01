package com.agharibi.review;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;


public interface ReviewRepository extends PagingAndSortingRepository<Review, Long> {

    @Override
    @PreAuthorize("@reviewRepository.findOne(#id)?.reviewer?.userName == authentication.name")
    default void delete(@Param("id") Long id) {

    }

    @Override
    @PreAuthorize("#review.reviewer?.userName == authenticatoin.name")
    default void delete(@Param("review") Review entity) {

    }
}
