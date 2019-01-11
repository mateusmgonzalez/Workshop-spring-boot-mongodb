package com.company.demo.config;

import com.company.demo.domain.Post;
import com.company.demo.domain.User;
import com.company.demo.dto.AuthorDTO;
import com.company.demo.dto.ComentDTO;
import com.company.demo.repository.PostRepository;
import com.company.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instatiation implements CommandLineRunner {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,bob));


        Post post = new Post(null, sdf.parse("21/02/2018"),"Partiu Viagem","Vou viajar para São Paulo", new AuthorDTO(maria));
        Post  post1 = new Post(null, sdf.parse("23/02/2018"),"Bom dia","Acordei feliz", new AuthorDTO(maria));


        ComentDTO comentDTO = new ComentDTO("Boa viagem mano !", sdf.parse("22/03/2018"), new AuthorDTO(alex));
        ComentDTO comentDTO1 = new ComentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
        ComentDTO comentDTO2 = new ComentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));

        post.getComents().addAll(Arrays.asList(comentDTO,comentDTO1));
        post1.getComents().addAll(Arrays.asList(comentDTO2));


        postRepository.saveAll(Arrays.asList(post,post1));



        maria.getPosts().addAll(Arrays.asList(post,post1));
        userRepository.save(maria);


    }
}
