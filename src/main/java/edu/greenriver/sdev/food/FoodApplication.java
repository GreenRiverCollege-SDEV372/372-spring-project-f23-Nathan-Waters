package edu.greenriver.sdev.food;

import edu.greenriver.sdev.food.db.RecipeRepository;
import edu.greenriver.sdev.food.db.ReviewRepository;
import edu.greenriver.sdev.food.models.Recipe;
import edu.greenriver.sdev.food.models.Review;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

// Author: Nathan Waters
// Date: 2/2/2024
// version: 1

@SpringBootApplication
public class FoodApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FoodApplication.class, args);
		RecipeRepository RecipeRepo = context.getBean(RecipeRepository.class);
		ReviewRepository ReviewRepo = context.getBean(ReviewRepository.class);


		List<Recipe> recipes = new ArrayList<>(List.of(
				new Recipe(1, "Pasta Carbonara", "https://example.com/pasta-carbonara", "John Doe",
						List.of("200g spaghetti", "100g pancetta", "2 eggs", "50g grated Parmesan cheese"),
						List.of("Boil spaghetti until al dente.", "Cook pancetta until crispy.", "Mix eggs and Parmesan, then toss with hot spaghetti.")
				),
				new Recipe(2, "Chocolate Cake", "https://example.com/chocolate-cake", "Jane Smith",
						List.of("1 cup flour", "1 cup sugar", "1/2 cup cocoa powder", "1 tsp baking powder"),
						List.of("Preheat oven to 350°F.", "Mix dry ingredients.", "Bake for 30 minutes.")
				),
				new Recipe(3, "Grilled Chicken Salad", "https://example.com/grilled-chicken-salad", "Mike Johnson",
						List.of("200g chicken breast", "Mixed salad greens", "Cherry tomatoes", "Balsamic vinaigrette"),
						List.of("Grill chicken until fully cooked.", "Toss salad greens with cherry tomatoes.", "Drizzle with dressing.")
				),
				// Add more recipes as needed
				new Recipe(4, "Vegetarian Stir-Fry", "https://example.com/vegetarian-stir-fry", "Emily White",
						List.of("Tofu", "Broccoli", "Carrots", "Soy sauce"),
						List.of("Cut tofu into cubes.", "Stir-fry tofu and vegetables in a pan.", "Add soy sauce for flavor.")
				),
				new Recipe(5, "Homemade Pizza", "https://example.com/homemade-pizza", "Chris Miller",
						List.of("Pizza dough", "Tomato sauce", "Cheese", "Pepperoni"),
						List.of("Roll out pizza dough.", "Spread tomato sauce and add toppings.", "Bake in the oven.")
				),
				new Recipe(6, "Greek Salad", "https://example.com/greek-salad", "Sophia Davis",
						List.of("Cucumbers", "Tomatoes", "Feta cheese", "Olives"),
						List.of("Chop vegetables and feta.", "Combine in a bowl with olives.", "Drizzle with olive oil.")
				),
				new Recipe(7, "Chicken Alfredo Pasta", "https://example.com/chicken-alfredo", "Michael Brown",
						List.of("Chicken breast", "Fettuccine pasta", "Alfredo sauce", "Parmesan cheese"),
						List.of("Cook chicken and pasta.", "Mix with Alfredo sauce.", "Sprinkle with Parmesan cheese.")
				),
				new Recipe(8, "Oatmeal Cookies", "https://example.com/oatmeal-cookies", "Lily Johnson",
						List.of("Oats", "Flour", "Butter", "Chocolate chips"),
						List.of("Combine ingredients in a bowl.", "Drop spoonfuls onto baking sheet.", "Bake until golden brown.")
				),
				new Recipe(9, "Tomato Basil Soup", "https://example.com/tomato-basil-soup", "David White",
						List.of("Tomatoes", "Onions", "Garlic", "Basil"),
						List.of("Saute onions and garlic.", "Add tomatoes and basil.", "Simmer until flavors blend.")
				),
				new Recipe(10, "Shrimp Scampi", "https://example.com/shrimp-scampi", "Megan Miller",
						List.of("Shrimp", "Linguine pasta", "Garlic", "White wine"),
						List.of("Saute garlic in butter.", "Add shrimp and white wine.", "Serve over linguine.")
				)
		));

		List<Review> reviews = new ArrayList<>(List.of(
				new Review(1, "Pasta Carbonara", 4, "Delicious pasta! The combination of pancetta and Parmesan is fantastic."),
				new Review(2, "Chocolate Cake", 5, "Incredibly moist and rich chocolate cake. A definite crowd-pleaser!"),
				new Review(3, "Grilled Chicken Salad", 4, "Healthy and flavorful salad. The grilled chicken adds a nice touch."),
				new Review(4, "Vegetarian Stir-Fry", 3, "Good veggie stir-fry, but could use a bit more seasoning."),
				new Review(5, "Homemade Pizza", 5, "Amazing homemade pizza! The crust is perfect, and the toppings are delicious."),
				new Review(6, "Greek Salad", 4, "Refreshing and authentic Greek salad. Love the combination of feta and olives."),
				new Review(7, "Chicken Alfredo Pasta", 4, "Creamy and satisfying chicken Alfredo. A classic comfort dish."),
				new Review(8, "Oatmeal Cookies", 5, "The best oatmeal cookies I've ever had! Chewy and full of chocolate chips."),
				new Review(9, "Tomato Basil Soup", 4, "Simple yet delicious tomato basil soup. Perfect for a cozy night."),
				new Review(10, "Shrimp Scampi", 5, "Mouthwatering shrimp scampi. The garlic and white wine sauce is superb.")
		));

		RecipeRepo.saveAll(recipes);
		ReviewRepo.saveAll(reviews);
	}

}
