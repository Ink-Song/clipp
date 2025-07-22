# Clipp

Clipp is a tool built in java for performing text operations via the CLI.
It performs these actions on text stored in the systems clipboard.
The resultant text is automatically copied back to the clipboard, so no copy and pasting necessary.

I made it for some quick coding practice, but also because I've twice this year had to manually convert lists into arrays, and I won't do it a third time.

Could I have just put them in a text file and run some quick python code on them? Yes. Instead, I made this program. Oh well.

### Current Limitations
The program is very new and very untested. Currently it struggles to handle the following
- [ ] **Non-Text clipboard contents**. Seems to just assume they're text, despite explicit checks.
- [ ] **Non-Sanitized text.** Things get freaky when you put java code in there. Which let me tell you, for testing purposes, that's very inconvenient.
- [ ] **Spaces and escape characters**. Trying to find and remove all instances of "Jar Jar" doesn't work, due to the space in the argument. Doesn't convert well to Regex.

