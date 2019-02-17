package com.trivago.challenge.newsfeed;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Comparator;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.trivago.challenge.newsfeed.dto.ChannelDto;
import com.trivago.challenge.newsfeed.dto.RssDto;
import com.trivago.challenge.newsfeed.model.ItemEntity;
import com.trivago.challenge.newsfeed.repo.ItemRepo;
import com.trivago.challenge.newsfeed.service.ItemService;

@SpringBootApplication
@EnableScheduling
public class NewsfeedApplication implements CommandLineRunner {


	@Value("${resource.newsfeed.technology}")
	private String resourceTechUrl;
	
	@Value("${resource.newsfeed.europe}")
	private String resourceEuropeUrl;
	
	
	
	@Autowired
	private ItemRepo itemRepo;
	
	@Autowired
	private ItemService itemService;
	
	public static void main(String[] args) {
		SpringApplication.run(NewsfeedApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		 HttpURLConnection urlConnectionTech = (HttpURLConnection) new URL(resourceTechUrl).openConnection();
		 HttpURLConnection urlConnectionEurope = (HttpURLConnection) new URL(resourceEuropeUrl).openConnection();
		 urlConnectionTech.addRequestProperty("User-Agent", "Mozilla/4.76"); 
		 urlConnectionTech.setRequestMethod("GET");
		 urlConnectionEurope.addRequestProperty("User-Agent", "Mozilla/4.76"); 
		 urlConnectionEurope.setRequestMethod("GET");
		 InputStream isTech = urlConnectionTech.getInputStream();
		 InputStream isEurope = urlConnectionEurope.getInputStream();
	     JAXBContext jaxbContext = JAXBContext.newInstance(RssDto.class);
	     Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	     RssDto rssDtoTech = (RssDto) jaxbUnmarshaller.unmarshal(isTech);
	     RssDto rssDtoEurope = (RssDto) jaxbUnmarshaller.unmarshal(isEurope);
	     ChannelDto channelDtoTech = rssDtoTech.getChannelObject();
	     ChannelDto channelDtoEurope = rssDtoEurope.getChannelObject();
	     itemRepo.saveAll(channelDtoTech.getItemEntities());
	     itemRepo.saveAll(channelDtoEurope.getItemEntities());	
	     
	     
	     itemService.setSortedItems(itemRepo.findAll()
											 .stream()
											 .sorted(Comparator.comparing(ItemEntity::getRating).reversed())
										     .collect(Collectors.toList()).subList(0, 5));
	}
	
	

}

