package com.nudennie.jetpack_compose_basic_codelab

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nudennie.jetpack_compose_basic_codelab.R.string
import com.nudennie.jetpack_compose_basic_codelab.ui.theme.JetpackComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeBasicTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {

    var shouldShowOnBoarding by rememberSaveable { mutableStateOf(true) }
    if (shouldShowOnBoarding) {
        OnBoardingScreen { shouldShowOnBoarding = false }
    } else {
        Greetings()
    }
}

// By passing a function and not a state to OnboardingScreen we are making this composable more
// reusable and protecting the state from being mutated by other composables.
@Composable
fun OnBoardingScreen(onContinueClicked: () -> Unit) {

    Surface {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome to the Basics Codelab!")
            Button(
                modifier = Modifier.padding(24.dp),
                onClick = onContinueClicked
            ) {
                Text("Continue")
            }
        }
    }
}

@Composable
fun Greetings(names: List<String> = List(1000) { "$it" }) {

    // A surface container using the 'background' color from the theme
    LazyColumn(modifier = Modifier.padding(4.dp)) {
        items(items = names) { name ->
            Greeting(name = name)
        }
    }
}

@Composable
fun Greeting(name: String) {

    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        CardContent(name)
    }
}

@Composable
fun CardContent(name: String) {
    var expandedState by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(24.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioHighBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(text = "Hello")
            Text(
                text = "$name!",
                style = MaterialTheme.typography.h4.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )

            if (expandedState) {
                Text(
                    text = "Odio minus et doloribus doloribus qui architecto molestias ut dolorum" +
                        " ipsum sit doloremque autem et consequatur reiciendis ab cumque atque. Ad dolor adipisci ad omnis repellat eum exercitationem recusandae et porro laudantium eos atque dolores. "
                )
            }
        }

        IconButton(
            onClick = { expandedState = !expandedState },
        ) {
            Icon(
                imageVector = if (expandedState) Filled.ExpandLess else Filled.ExpandMore,
                contentDescription = if (expandedState) stringResource(string.show_less)
                else stringResource(string.show_more),
            )
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeBasicTheme {
        Greetings()
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    JetpackComposeBasicTheme {
        // Assigning onContinueClicked to an empty lambda expression means "do nothing", which is perfect for a preview.
        OnBoardingScreen(onContinueClicked = {})
    }
}
