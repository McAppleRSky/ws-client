package ru.mrs;

import org.junit.jupiter.api.Test;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomUtils.nextInt;
import static org.junit.jupiter.api.Assertions.*;

class PostTest {

    @Test
    void testToString() {
        Post post = new Post();
        int id = nextInt();
        String title = randomAlphabetic(nextInt()%30);
        post.setId(id);
        post.setTitle(title);
        assertEquals(String.format("Post {id=%d, title='%s'}", id, title), post.toString());
    }
}