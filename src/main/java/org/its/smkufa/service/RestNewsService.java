package org.its.smkufa.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.its.smkufa.entity.News;
import org.its.smkufa.repository.NewsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RestNewsService implements NewsService {

	@Inject
	private NewsRepository newsRepository;

	@Override
	public News getNewsById(long id) {
		// TODO Auto-generated method stub
		return newsRepository.findById(id);
	}

	@Override
	public List<News> findNewsByName(String name) {
		// TODO Auto-generated method stub
		return newsRepository.findByName(name);
	}

	@Override
	@Transactional
	public News saveNews(News news) {
		// TODO Auto-generated method stub
		news.setId(0);
		news.setCreateDate(new Date());

		return newsRepository.save(news);
	}

	@Override
	@Transactional
	public News updateNews(long id, News news) {
		// TODO Auto-generated method stub
		News c = getNewsById(news.getId());
		if (c != null) {
			c.setName(news.getName());
			c.setContent(news.getContent());
			c.setCategory(news.getCategory());
		}
		return c;
	}

	@Override
	@Transactional
	public void deleteNews(long id) {
		newsRepository.delete(id);

	}

}
