---
name: desktop
description: >-
  Adds or extends nopCommerce demo desktop/shopping-cart Selenium tests using
  this repo's Page Object pattern, BaseTests hooks, and MethodHandles
  notification asserts. Use when the user mentions /desktop, Desktops, Computers
  menu, Add to cart, bar-notification, AddItemToCart, or catalog tests on
  demo.nopcommerce.com.
disable-model-invocation: true
---

# Desktop tests & notification asserts (project_three)

## Stack & layout

- **Site**: `https://demo.nopcommerce.com/` (`src/data/testData.json` → `URL`)
- **Driver**: `BaseTests` attaches to Chrome `debuggerAddress` `127.0.0.1:9222` (Chrome must be running with remote debugging).
- **Hooks**: `@BeforeMethod` / `@AfterMethod` call `returnHome()` → `driver.get(URL)` + `new HomePage(driver)`.
- **Pattern**: locators + actions in `pages/*` extending `utils.MethodHandles`; tests extend `base.BaseTests`.

## Desktop flow (reference)

1. `homePage.openDesktopUnderComputers(time)` — hover `a[href='/computers']`, click `a[href='/desktops']`.
2. `desktopPage.clickOnLenovoIdeaLink()` — `linkText("Lenovo IdeaCentre")`.
3. `itemInformationPage.clickOnAddToCartBtn()` — `id("add-to-cart-button-3")` (product-specific).
4. **Assert notification** via `MethodHandles` (not raw TestNG in pages unless user asks).

Canonical test: `src/test/java/shoppingCart/AddItemToCart.java`.

## Notification assert (reuse everywhere)

Implemented in `MethodHandles`:

```java
assertNotificationContains("The product has been added to your", 10);
// or custom locator:
assertNotificationContains("text", By.cssSelector(".bar-notification.success"), 10);
```

- Default locator: `.bar-notification.success` (nopCommerce green bar).
- Waits for visibility (`webElement`), then checks **contains** (partial text OK).
- Throws `AssertionError` on failure (TestNG reports as failed test).

**Rules when extending:**

- Put **new shared waits/actions/asserts** in `MethodHandles`, not duplicated in each page.
- Page classes call `assertNotificationContains(...)` after the action that triggers the bar.
- Keep tests thin: arrange → act in pages → assert via page/MethodHandles.

## Adding a new desktop-related test

1. Create or extend a class under `src/test/java/` extending `BaseTests`.
2. Reuse `homePage` from `goHomeBeforeTest`; do not create a second `WebDriver`.
3. Chain page objects; return next page from actions (existing style).
4. After cart/login actions that show the green bar, call `assertNotificationContains` with the **shortest unique substring** from the UI (inspect once).
5. Prefer **15s** wait on menu hover if Cloudflare or slow loads; product clicks often use **5–10s**.
6. Do **not** add hover bypass, auto Chrome launch, or extra JSON fields unless the user explicitly requests it.
7. Keep diffs small; match naming: `clickOn…`, `open…`, `int time` parameters.

## Locator tips (nopCommerce)

| Goal | Locator style |
|------|----------------|
| Top menu Computers / Desktops | `a[href='/computers']`, `a[href='/desktops']` |
| Product title on list | `linkText` or xpath within `div.product-item` |
| Add to cart on **detail** page | often `id("add-to-cart-button-{productId}")` — verify in DevTools |
| Success message | `.bar-notification.success` |

## Common failures (do not “fix” with heavy code unless asked)

- **Timeout on Computers**: page is Cloudflare or not home — user must pass verification in the attached Chrome tab.
- **Chrome 9222**: connection errors if debug Chrome is closed.
- **Wrong add-to-cart id**: button id is per product on nopCommerce.

## Optional catalog smoke test

`src/test/java/catalog/DesktopTests.java` — opens Desktops via menu only; extend only if user wants navigation-only coverage.

## Examples

**Full cart + notification** (copy pattern from `AddItemToCartTests`):

```java
DesktopPage desktopPage = homePage.openDesktopUnderComputers(15);
ItemInformationPage itemPage = desktopPage.clickOnLenovoIdeaLink();
itemPage.clickOnAddToCartBtn();
itemPage.assertNotificationContains("The product has been added to your", 10);
```

**Assert after any page action** (class extends `MethodHandles`):

```java
click(someBtn, 10);
assertNotificationContains("expected fragment", 10);
```
